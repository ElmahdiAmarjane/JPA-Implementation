package estm.dsic.jee.rest.business;

import java.io.Serializable;
import java.util.List;

import estm.dsic.jee.rest.dal.NoteDao;
import estm.dsic.jee.rest.models.Note;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ImplNoteServices implements INoteServices,Serializable {
     @Inject
       private NoteDao noteDao;
    @Override
    public boolean create(Note note) {
         noteDao.create(note);
         return true;
    }
   @Override
   public boolean delete(Long id) {
    //  return noteDao.delete(id);
    return false;
   }
   @Override
   public boolean update(Note note) {
      //return noteDao.updateNote(note);
      return false;
   }
   @Override
   public List<Note> getAll(int iduser) {
        //return noteDao.getAll(iduser);
        return null;
   }

    
}
