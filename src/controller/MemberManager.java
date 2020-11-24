/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Member;

/**
 *
 * @author User
 */
public class MemberManager {
    static MemberManager instance;
    private Member member;
    private boolean login;
    
    public static MemberManager getInstance() {
        if (instance == null) {
            instance = new MemberManager();
        }
        return instance;
    }
    
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
    public boolean getLogin(){
        return login;
    }
    public void setLogin(boolean login){
        this.login = login;
    }
}
