package co.api.trescubos.persistence;

import co.api.trescubos.entities.TransactionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad 
 * @author Luis Suarez
 */ 
@Stateless
public class TransactionPersistence {
    
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "TrescubosPU")
    private EntityManager entityManager;
    
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla
     * @return lista resultante
     */
    public List<TransactionEntity> findAll(){
        Query queryTransaction = entityManager.createQuery("select p from transactions p");
        return queryTransaction.getResultList();
    }
    
    /**
     * Metodo que busca un objeto mediante su id
     * @param id
     * @return objeto encontrado
     */
    public TransactionEntity find(Long id){
        return entityManager.find(TransactionEntity.class, id);
    }
    
    /**
     * Metodo para crear un objeto de la entidad 
     * @param TransactionNew
     * @return Nuevo
     */
    public TransactionEntity create(TransactionEntity TransactionNew){
        entityManager.persist(TransactionNew);
        return TransactionNew;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad
     * @param transactionUpdated
     * @return actualizado
     */
    public TransactionEntity update(TransactionEntity transactionUpdated){
        return entityManager.merge(transactionUpdated);
    }
    
    /**
     * Metodo usado para eliminar
     * @param id 
     */
    public void remove(Long id){
        TransactionEntity TransactionDelet = entityManager.find(TransactionEntity.class, id);
        entityManager.remove(TransactionDelet);
    }
}
