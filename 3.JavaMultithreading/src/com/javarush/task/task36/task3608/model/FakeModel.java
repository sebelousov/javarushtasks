package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("A", 101, 1));
        users.add(new User("B", 201, 1));
        users.add(new User("C", 301, 3));
        users.add(new User("D", 401, 4));
        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        FakeModel fakeModel = new FakeModel();
        fakeModel.loadUsers();

        for (User user : fakeModel.getModelData().getUsers()) {
            System.out.println(user);
        }
    }
}
