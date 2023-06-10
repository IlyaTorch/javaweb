package by.bsu.jwd.db.dao;


import by.bsu.jwd.db.dto.UserDTO;

import java.util.List;

public interface UserDAO {

    public List<UserDTO> getAllUsers();
}
