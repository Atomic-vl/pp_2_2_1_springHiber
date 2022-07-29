package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   public void deleteUser (long id) {
      User user = sessionFactory.getCurrentSession().get(User.class,id);
      sessionFactory.getCurrentSession().delete(user);
   }

   @Override
   public void showUserWithCar(String model, int series) {
      String sqlStr = "";
      Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE car.model=:model and car.series=:series");
      query.setParameter("model", model);
      query.setParameter("series",series);
      List<User> userList = query.getResultList();
      userList.forEach(System.out::println);

   }

}
