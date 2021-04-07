/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Modelo.Revision;
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
import iDAO.IRevisionDAO;
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
 * @author Andres Camilo Gonzalez Velasquez & Cristian Stiven Perdomo Garcia
 *         Cod: 20201187519                   Cod: 202011
 */
public class RevisiónDAO implements IRevisionDAO{
    @Override
    public List<Revision> obtenerRevisiones(String plazo){
       Revision aw = null;
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
            MongoDatabase garajeBD = mongoClient.getDatabase("GarajeBD");
            MongoCollection<Document> RevisionCollection = garajeBD.getCollection("vehiculo");
            // find one document with new Document
            Document v1 = RevisionCollection.find(new Document("placa", plazo)).first();
            //vr.setPlaca(v1.);
            System.out.println("revision " + v1.toJson());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return (List<Revision>) aw;

    }
    
    @Override
    public ArrayList<Revision> obtenerRevision(String plazo){
        ArrayList<Revision> lrp = new ArrayList();
        //Para convertir objetos de java en documentos tipo BSON en Mongo
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        //Conexión a la BD Mongo
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        
        MongoCollection<Revision> IRevisionMongo = db.getCollection("revision", Revision.class);
        FindIterable<Revision> cur = IRevisionMongo.find();
        Iterator<Revision> iter = cur.iterator();
        Revision v = null;
        while (iter.hasNext()) {
            v = iter.next();
            lrp.add(v);
        }
        return lrp;
    }
    
    @Override
    public void insertarRevision(Revision revision){
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        
        MongoCollection<Revision> IRevisionMongo = db.getCollection("revision", Revision.class);
        IRevisionMongo.insertOne(revision);
    }
    
    @Override
    public void actualizarRevision(Revision revision){
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        
        MongoCollection<Revision> revisionMongo = db.getCollection("revision", Revision.class);
        System.out.println(revision.toString());
        Revision v = revisionMongo.find(eq("_id", revision.getId())).first();
        Document filterByid = new Document("_id", v.getId());
        FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
        Revision updatedRevision = revisionMongo.findOneAndReplace(filterByid, revision, returnDocAfterReplace);
    }
    
    @Override
    public void eliminarRevision(Revision revision){
    CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://root:santafe2021@cluster0.vigaa.mongodb.net/GarajeBD?authSource=admin&replicaSet=atlas-10ow43-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
        MongoDatabase db = mongoClient.getDatabase("GarajeBD").withCodecRegistry(codecRegistry);
        
        MongoCollection<Revision> revisionMongo = db.getCollection("revision", Revision.class);
        Document filterByid = new Document("revision",revision.vehiculo);
        DeleteResult res= revisionMongo.deleteOne(filterByid);
    }
}
