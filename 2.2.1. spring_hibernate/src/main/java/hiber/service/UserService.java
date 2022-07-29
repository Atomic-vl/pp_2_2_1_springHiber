package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void deleteUser (long id);
    public void showUserWithCar(String model, int series);
}
