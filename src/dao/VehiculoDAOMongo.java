/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Modelo.Vehiculo;
import iDAO.IVehiculoDAO;
import java.util.List;
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
import java.util.ArrayList;
import java.util.Iterator;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class VehiculoDAOMongo implements IVehiculoDAO {

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        ArrayList<Vehiculo> lv = new ArrayList();
        //Para convertir objetos de java en documentos tipo BSON en Mongo
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        //Conexión a la BD Mongo
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        MongoCollection<Vehiculo> vehiculoMongo = db.getCollection("vehiculo", Vehiculo.class);
        FindIterable<Vehiculo> cur = vehiculoMongo.find();
        Iterator<Vehiculo> iter = cur.iterator();
        Vehiculo v = null;
        while (iter.hasNext()) {
            v = iter.next();
            lv.add(v);
        }
        return lv;

    }

    public Vehiculo obtenerVehiculo2(String placa) {
        Vehiculo vr = null;
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
            //MongoCollection<Document> vehiculoMongo = mongoClient.getDatabase("GarajeBD").getCollection("vehiculo");
            //try (MongoClient mongoClient = MongoClients.create(System.getProperty("mongodb.uri"))) {
            MongoDatabase garajeBD = mongoClient.getDatabase("GarajeBD");
            MongoCollection<Document> vehiculosCollection = garajeBD.getCollection("vehiculo");
            // find one document with new Document
            Document v1 = vehiculosCollection.find(new Document("placa", placa)).first();
            //vr.setPlaca(v1.);
            System.out.println("Vehiculo " + v1.toJson());
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return vr;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarVehiculo(Vehiculo vehiculo) {
        //ConnectionString connectionString = new ConnectionString("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true");
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        MongoCollection<Vehiculo> vehiculoMongo = db.getCollection("vehiculo", Vehiculo.class);
        //MongoCollection<Vehiculo> vehiculoMongo = mongoClient.getDatabase("GarajeBD").getCollection("vehiculo",Vehiculo.class);
        //Document vehiculoDoc = new Document();
        //vehiculoDoc.append("placa",vehiculo.getPlaca())
        //.append("marca",vehiculo.getMarca())
        //.append("color",vehiculo.getMarca())
        //.append("propietario",vehiculo.getPropietario().getId())
        //.append("modelo", vehiculo.getModelo());
        vehiculoMongo.insertOne(vehiculo);

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarVehiculo(Vehiculo vehiculo) {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        MongoCollection<Vehiculo> vehiculoMongo = db.getCollection("vehiculo", Vehiculo.class);
        Vehiculo v = vehiculoMongo.find(eq("placa", vehiculo.getPlaca())).first();
        Document filterByPlaca = new Document("placa", v.getPlaca());
        FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
        Vehiculo updatedVehiculo = vehiculoMongo.findOneAndReplace(filterByPlaca, vehiculo, returnDocAfterReplace);
        
    }

    @Override
    public void eliminarVehiculo(Vehiculo vehiculo) {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        MongoCollection<Vehiculo> vehiculoMongo = db.getCollection("vehiculo", Vehiculo.class);
        Vehiculo v = vehiculoMongo.find(eq("placa", vehiculo.getPlaca())).first();
        Document filterByPlaca = new Document("placa", v.getPlaca());
        DeleteResult res= vehiculoMongo.deleteOne(filterByPlaca);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vehiculo obtenerVehiculo(String placa) {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        MongoCollection<Vehiculo> vehiculoMongo = db.getCollection("vehiculo", Vehiculo.class);
        Vehiculo v = vehiculoMongo.find(eq("placa", placa)).first();
        System.out.println("Vehiculo encontrado:\t" + v.toString());
        return v;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
