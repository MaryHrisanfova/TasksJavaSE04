package com.github.MaryHrisafova.FilmsAndActors;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by hrisanfovamm on 20.10.2015.
 */
public class Film implements Serializable {
    private String name;
    private Collection<Actor> actors = new LinkedList<Actor>();

    Film(){

    }
    Film(Collection<Film> films, String name) {//конструктор обеспечивает добавление в коллекцию
        this.name = name;
        films.add(this);
    }

    public static void delFilm(Collection<Film> films, Film film) {
        films.remove(film);
    }

    public String setFilmName(String name) {
        return (this.name=name);
    }

    public String getFilmName() {
        return (this.name);
    }

    public void setActor(Actor oneActor) {
        this.actors.add(oneActor);
    }

    public Collection<Actor> getActors() {
        return (this.actors);
    }

    public static Film findFilmInCollection(Collection<Film> films,String film){
        Iterator<Film> it = films.iterator();
        Film foundedFilm=new Film();
        while (it.hasNext()) {
            Film f = it.next();
            if (film.equals(f.getFilmName())){
                foundedFilm=f;
                System.out.println("I found this film");
            }
            else {
                System.out.println("I didn't find this film");
            }
        }
        return foundedFilm;
    }


    @Override
    public String toString() {
        return (name + "\t" + "Actors:" + actors.toString());
    }


    public static void serialization(Collection<Film> films) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream("F.ser")));
            out.writeObject(films);
            //out.close();//закрывает также и буфер
            System.out.printf("Serialized data about all films is saved in F.ser" + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (out != null)
                try {
                    out.close();//закрывает также и буфер
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
    }


    public static void deserialization(Collection<Film> films) {
        ObjectInputStream in = null;
        File fileIn = new File("F.ser");

            try {
                in = new ObjectInputStream(new BufferedInputStream(
                        new FileInputStream(fileIn)));
                films = (Collection<Film>) in.readObject();
                System.out.print("Deserialization:" + films.toString());
            }
            catch (EOFException e) {
                films = Film.standartCollection();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            finally {
                if (in != null)
                    try {
                        in.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
            }

    }

    public static Collection<Film> standartCollection(){
        Collection<Film> films = new LinkedList<Film>();
        Actor actor1 = new Actor("Harry", "S", 1991);
        Actor actor2 = new Actor("Barry", "M", 1988);
        Actor actor3 = new Actor("Sarry", "N", 1964);
        Actor actor4 = new Actor("Varry", "P", 1959);

        Film film1 = new Film(films,"Sun");
        film1.setActor(actor1);
        film1.setActor(actor2);
        film1.setActor(actor4);
        Film film2 = new Film(films,"Gun");
        film2.setActor(actor3);
        return films;
    }

}



