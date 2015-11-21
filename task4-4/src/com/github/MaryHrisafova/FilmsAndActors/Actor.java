package com.github.MaryHrisafova.FilmsAndActors;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by hrisanfovamm on 20.10.2015.
 */
public class Actor implements Serializable{
    private String firstname;
    private String lastname;
    private Integer yearOfBirth;

    public Actor(){

    }

    Actor (String firstname,String lastname,Integer yearOfBirth){
        this.firstname=firstname;
        this.lastname=lastname;
        this.yearOfBirth=yearOfBirth;
    }

    public String getActorName(){
        return (this.firstname);
    }

    @Override
    public String toString() {
        return (firstname+" "+lastname+", year of birth:"+yearOfBirth+" ");
    }

    public static Actor findActorInFilm(Collection<Film> films,String film,String actorName){
        Film foundedFilm=Film.findFilmInCollection(films, film);
        Iterator<Actor> itActor = foundedFilm.getActors().iterator();
        Actor foundedActor=new Actor();
        while (itActor.hasNext()) {
            Actor a = itActor.next();
            if (actorName.equals(a.getActorName())){
                foundedActor=a;
                System.out.println("I found this actor");

            }
            else {
                System.out.println("I didn't find this actor");
            }

        }
        return foundedActor;

    }


    public static void delActor(Collection<Film> films,String film, Actor actor) {
        Film foundedFilm=Film.findFilmInCollection(films, film);
        //foundedFilm.getActors().remove(foundedActor);
        foundedFilm.getActors().remove(actor);
    }
}
