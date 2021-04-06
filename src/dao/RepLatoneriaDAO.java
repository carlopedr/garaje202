/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import Modelo.RepLatoneria;
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
import iDAO.IRepLatoneriaDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;


/**
 *
 * @author PABLO ALEXANDER SALAZAR SANCHEZ - 20201187152
 */
public class RepLatoneriaDAO implements IRepLatoneriaDAO {
    @Override
    public RepLatoneria obtenerRepLatoneria(String placa){
        RepLatoneria vr = null;
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
            MongoDatabase garajeBD = mongoClient.getDatabase("GarajeBD");
            MongoCollection<Document> replatoneriaCollection = garajeBD.getCollection("vehiculo");
            // find one document with new Document
            Document v1 = replatoneriaCollection.find(new Document("placa", placa)).first();
            //vr.setPlaca(v1.);
            System.out.println("replatoneria " + v1.toJson());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return vr;

    }

    @Override
    public List<RepLatoneria> obtenerRepLatonerias() {
        ArrayList<RepLatoneria> lv = new ArrayList();
        //Para convertir objetos de java en documentos tipo BSON en Mongo
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        //Conexión a la BD Mongo
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        MongoCollection<RepLatoneria> replatoneriaMongo = db.getCollection("replatoneria", RepLatoneria.class);
        FindIterable<RepLatoneria> cur = replatoneriaMongo.find();
        Iterator<RepLatoneria> iter = cur.iterator();
        RepLatoneria v = null;
        while (iter.hasNext()) {
            v = iter.next();
            lv.add(v);
            return lv;
        }
        return lv;
    }

    @Override
    public void insertarRepLatoneria(RepLatoneria replatoneria) {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        MongoCollection<RepLatoneria> repmelatoneriaMongo = db.getCollection("replatoneria", RepLatoneria.class);
        repmelatoneriaMongo.insertOne(replatoneria);
    }

    @Override
    public void actualizarRepLatoneria(RepLatoneria replatoneria) {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        MongoCollection<RepLatoneria> replatoneriaMongo = db.getCollection("replatoneria", RepLatoneria.class);
        RepLatoneria v = replatoneriaMongo.find(eq(" id", replatoneria.getId())).first();
        Document filterByid = new Document(" id", v.getId());
        FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
        RepLatoneria updatedVehiculo = replatoneriaMongo.findOneAndReplace(filterByid, replatoneria, returnDocAfterReplace);
    }

    public void eliminarRepMecanica(RepLatoneria replatoneria) {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        MongoCollection<RepLatoneria> replatoneriaMongo = db.getCollection("replatoneria", RepLatoneria.class);
        Document filterByid = new Document("vehiculo",replatoneria.vehiculo);
        DeleteResult res= replatoneriaMongo.deleteOne(filterByid);
    }

    @Override
    public void eliminarRepLatoneria(RepLatoneria replatoneria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
    

