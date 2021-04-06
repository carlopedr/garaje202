package dao;

import Modelo.RepMecanica;
import Modelo.Vehiculo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.result.DeleteResult;
import iDAO.IRepMecanicaDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
@author DUVERNEY NAVEROS COD.20201187763
        YOSSELINE CHILITO COD.20201187434
 */

public class RepMecanicaDAO implements IRepMecanicaDAO{
    @Override
    public RepMecanica obtenerRepMecanica(String placa){
        RepMecanica vr = null;
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
            MongoDatabase garajeBD = mongoClient.getDatabase("GarajeBD");
            MongoCollection<Document> repmecanicaCollection = garajeBD.getCollection("vehiculo");
            // find one document with new Document
            Document v1 = repmecanicaCollection.find(new Document("placa", placa)).first();
            //vr.setPlaca(v1.);
            System.out.println("repmecanica " + v1.toJson());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return vr;

    }

    @Override
    public List<RepMecanica> obtenerRepMecanicas() {
        ArrayList<RepMecanica> lrp = new ArrayList();
        //Para convertir objetos de java en documentos tipo BSON en Mongo
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        //Conexión a la BD Mongo
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        MongoCollection<RepMecanica> repmecanicaMongo = db.getCollection("repmecanica", RepMecanica.class);
        FindIterable<RepMecanica> cur = repmecanicaMongo.find();
        Iterator<RepMecanica> iter = cur.iterator();
        RepMecanica v = null;
        while (iter.hasNext()) {
            v = iter.next();
            lrp.add(v);
        }
        return lrp;
    }

    @Override
    public void insertarRepMecanica(RepMecanica repmecanica) {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        MongoCollection<RepMecanica> repmecanicaMongo = db.getCollection("repmecanica", RepMecanica.class);
        repmecanicaMongo.insertOne(repmecanica);
    }

    @Override
    public void actualizarRepMecanica(RepMecanica repmecanica) {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        MongoCollection<RepMecanica> repmecanicaMongo = db.getCollection("repmecanica", RepMecanica.class);
        System.out.println(repmecanica.toString());
        RepMecanica v = repmecanicaMongo.find(eq("_id", repmecanica.getId())).first();
        Document filterByid = new Document("_id", v.getId());
        FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
        RepMecanica updatedVehiculo = repmecanicaMongo.findOneAndReplace(filterByid, repmecanica, returnDocAfterReplace);
    }

    @Override
    public void eliminarRepMecanica(RepMecanica repmecanica) {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        MongoCollection<RepMecanica> repmecanicaMongo = db.getCollection("repmecanica", RepMecanica.class);
        Document filterByid = new Document("vehiculo",repmecanica.vehiculo);
        DeleteResult res= repmecanicaMongo.deleteOne(filterByid);
    }
}
