package bin;
import data.User;
import data.UserList;

public class UserManage {

    public static boolean registration(int qmNumber, String fullName, String email){
        if(!isDuplicate(qmNumber, email)){
            UserList userList = new UserList();
            userList.addUser(new User(qmNumber, fullName, email));
            return true;
        }
        return false;
    }

    static boolean isDuplicate(int qmNumber, String email) {
        UserList userList = new UserList();
        for (User user:userList.getList()) {
            if (qmNumber == user.getQmNumber())
                return true;
            if (email.equals(user.getEmail()))
                return true;
        }
        return false;
    }

    public static boolean isExist(int qmNumber) {
        UserList userList = new UserList();
        for (User user:userList.getList()) {
            if (qmNumber == user.getQmNumber())
                return true;
        }
        return false;
    }

    public static User findUserById(int qmNumber) {
        UserList userList = new UserList();
        for (User user:userList.getList()) {
            if (qmNumber == user.getQmNumber())
                return user;
        }
        return null;
    }
}

//
//