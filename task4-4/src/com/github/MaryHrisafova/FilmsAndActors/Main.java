package com.github.MaryHrisafova.FilmsAndActors;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * Created by hrisanfovamm on 20.10.2015.
 */

public class Main{

    public static void main(String[] aArgs) throws IOException, EOFException {

        Collection<Film> films = new LinkedList<Film>();
        File fileIn = new File("F.ser");
        if (fileIn.exists() & fileIn.length() != 0) {//если файл существует и не пуст, то десериалимзуем объекты класса Film
            Film.deserialization(films);
        } else {//иначе создаем стандартную коллекцию фильмов
            films = Film.standartCollection();
        }
        System.out.print(films);
        System.out.println();

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String commandWhatToDo, commandObjectIs, commandObjectName;
        do {
            System.out.println("What to do? del/add"+"\n");
            commandWhatToDo = stdin.readLine();
            if (commandWhatToDo.equals("exit")) {
                System.out.println("Save this changes?  Yes/No"+"\n");
                String yesNo=stdin.readLine();
                if (yesNo.equals("Yes")|yesNo.equals("yes"))
                {
                    Film.serialization(films);
                }
                stdin.close();
                break;} //единственный выход из цикла

            System.out.println("What? film/actor"+"\n");
            commandObjectIs = stdin.readLine();
            System.out.println("What it's name?"+"\n");
            commandObjectName = stdin.readLine();

            if (commandWhatToDo.equals("del")& commandObjectIs.equals("film")) {//удаление фильма по его наименованию
                Film.delFilm(films, Film.findFilmInCollection(films, commandObjectName));
            }

            if (commandWhatToDo.equals("add") & commandObjectIs.equals("film")) //добавление фильма
            {
                Film f=new Film(films,commandObjectName);
            }

            if (commandWhatToDo.equals("del")& commandObjectIs.equals("actor")) {//удаление актера из фильма
                System.out.println("Enter the film"+"\n");
                String commandFilmToActor = stdin.readLine();
                Actor.delActor(films, commandFilmToActor, Actor.findActorInFilm(films, commandFilmToActor, commandObjectName));
            }

            if (commandWhatToDo.equals("add")& commandObjectIs.equals("actor")) {//удаление актера из фильма
                System.out.println("Enter the year of birth of this actor"+"\n");
                Integer commandYearActor = Integer.parseInt(stdin.readLine());
                System.out.println("Enter the name of this actor"+"\n");
                String commandNameActor = stdin.readLine();
                System.out.println("Enter the film"+"\n");
                String commandFilmToActor = stdin.readLine();
                Actor a=new Actor(commandObjectName,commandNameActor,commandYearActor);
                Film.findFilmInCollection(films,commandFilmToActor).setActor(a);
            }

            System.out.println();
            System.out.print("Result collection is:"+"\n"+films);
        }
        while (true);

    }
}