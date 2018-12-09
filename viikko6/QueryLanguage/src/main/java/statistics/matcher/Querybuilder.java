/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author antlammi
 */
public class Querybuilder {
    public Matcher query;
    public Querybuilder(){
        query = new All();
    }
    public Matcher build(){
        Matcher result = query;
        this.query = new All();
        return result;
       
    }
    public Querybuilder oneOf(Matcher m1, Matcher m2){
        this.query = new Or(m1, m2);
        return this;
    }
    public Querybuilder playsIn(String team){
        this.query = new And(this.query, new PlaysIn(team));
        return this;
    }
    public Querybuilder hasAtLeast(Integer count, String category){
        this.query = new And(this.query, new HasAtLeast(count, category));
        return this;
    }
    
    public Querybuilder hasFewerThan(Integer count, String category){
        this.query = new And(this.query, new HasFewerThan(count,category));
        return this;
    }
}

