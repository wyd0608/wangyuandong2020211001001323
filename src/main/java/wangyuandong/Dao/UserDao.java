package wangyuandong.Dao;

import wangyuandong.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into register(id, username, password, email, gender, birthdate) values (?,?,?,?,?,?);";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,user.getID());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPasswords());
        preparedStatement.setString(4, user.getEmails());
        preparedStatement.setString(5, user.getGender());
        preparedStatement.setDate(6, (java.sql.Date)user.getBirthdate());
        preparedStatement.executeUpdate();
        return true;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "delete from Registers where ID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getID());
        ps.executeUpdate();
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "update Registers set username ="+user.getUsername()+
                ", passwords = "+user.getPasswords()+
                ", emails = "+user.getEmails()+
                ", gender = "+user.getGender()+
                ", birthdate = "+user.getBirthdate()+" where ID="+user.getID();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "select ID ,username,passwords,emails,gender,birthdate from Registers where ID = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,id);

        ResultSet rs = st.executeQuery();
        User user = null;
        if (rs.next()){
            user = new User();
            user.setID(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPasswords(rs.getString("password"));
            user.setEmails(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {

        String sql="select * from Registers where username=? and passwords=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setID(rs.getString("ID"));
            user.setUsername(rs.getString("username"));
            user.setPasswords(rs.getString("passwords"));
            user.setEmails(rs.getString("emails"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "select ID ,username,passwords,emails,gender,birthdate from Registers where username = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs = st.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<User>();
        while (rs.next()){
            user.setID(rs.getString("ID"));
            user.setUsername(rs.getString("username"));
            user.setPasswords(rs.getString("passwords"));
            user.setEmails(rs.getString("emails"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "select ID ,username,passwords,emails,gender,birthdate from Registers where passwords = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs = st.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<User>();
        while (rs.next()){
            user.setID(rs.getString("ID"));
            user.setUsername(rs.getString("username"));
            user.setPasswords(rs.getString("passwords"));
            user.setEmails(rs.getString("emails"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "select ID ,username,passwords,emails,gender,birthdate from Registers where passwords = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs = st.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<User>();
        while (rs.next()){
            user.setID(rs.getString("ID"));
            user.setUsername(rs.getString("username"));
            user.setPasswords(rs.getString("passwords"));
            user.setEmails(rs.getString("emails"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select ID ,username,passwords,emails,gender,birthdate from Registers where gender = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs = st.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<User>();
        while (rs.next()){
            user.setID(rs.getString("ID"));
            user.setUsername(rs.getString("username"));
            user.setPasswords(rs.getString("passwords"));
            user.setEmails(rs.getString("emails"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "select ID ,username,passwords,emails,gender,birthdate from Registers where birthdate = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setDate(1, (java.sql.Date) birthDate);
        ResultSet rs = st.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<User>();
        while (rs.next()){
            user.setID(rs.getString("ID"));
            user.setUsername(rs.getString("username"));
            user.setPasswords(rs.getString("passwords"));
            user.setEmails(rs.getString("emails"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "select ID ,username,passwords,emails,gender,birthdate from Registers";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<User>();
        while (rs.next()){
            user.setID(rs.getString("ID"));
            user.setUsername(rs.getString("username"));
            user.setPasswords(rs.getString("passwords"));
            user.setEmails(rs.getString("emails"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }
}
