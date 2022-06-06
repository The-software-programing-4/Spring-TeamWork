package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Discuss;
import com.example.bookandmovie.Entity.Groupt;
import com.example.bookandmovie.Entity.User;

import java.util.List;

public interface DiscussService {
    public void addDiscuss(Discuss discuss);
    public Discuss getDiscussById(int id);
    public List<Discuss> listDiscussU(int uid);
    public List<Discuss> listDiscussG(int gid);
    public Groupt findGroupByGid(int gid);
    public List<Groupt> findGroupUidIn(int uid);
    public List<User> findMemberByGid(int gid);

}
