package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Discuss;
import com.example.bookandmovie.Entity.Group;
import com.example.bookandmovie.Entity.User;

import java.util.List;

public interface DiscussService {
    public void addDiscuss(Discuss discuss);
    public Discuss getDiscussById(int id);
    public List<Discuss> listDiscussU(int uid);
    public List<Discuss> listDiscussG(int gid);
    public Group findGroupByGid(int gid);
    public List<Group> findGroupUidIn(int uid);
    public List<User> findMemberByGid(int gid);

}
