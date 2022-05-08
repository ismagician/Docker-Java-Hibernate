# Crear contenedor Java Hibernate

<h3> SetUp </h3>


Primero se debe ver la IP de  WLS con el comando ``` ipconfig ``` 

![imagen](https://user-images.githubusercontent.com/92187317/167285911-c9a1b5b6-16b9-4d22-a508-db58b029692f.png)

En el archivo persistance.xml cambiar localhost por la IP del WSL

![imagen](https://user-images.githubusercontent.com/92187317/167287731-9afe0e04-44ef-44e7-9cf4-51e1fca07599.png)

En File > Project Structure > Artifacts > Le dan al + > seleccionar JAR y elegir la opción from modules with dependencies

![imagen](https://user-images.githubusercontent.com/92187317/167286083-a9a59b2b-42ab-46fd-b87e-5c120574a571.png)

En el apartado Main Class le dan a la carpeta y seleccionar la clase Main

![imagen](https://user-images.githubusercontent.com/92187317/167286133-f6b658d4-2636-4f5f-b2c9-f988b5b8e330.png)

Las demás opciones las dejan como están > OK

![imagen](https://user-images.githubusercontent.com/92187317/167286168-fc06b91e-ad83-4a6e-9781-c99c0cb4289a.png)

Marcar la opción Include in project build > Apply y Ok


![imagen](https://user-images.githubusercontent.com/92187317/167286245-60284897-327d-4788-b853-2de186fc6473.png)

En la clase Main agregué código para hacer una consulta, les va a marcar errores, que se solucionan agregando las clases que les indique Intellij 
 
 ```java
            Collection emps = entityManager.createQuery("SELECT e FROM MissionComanders e").getResultList();
            for (Iterator i = emps.iterator(); i.hasNext();) {
                MissionComanders e = (MissionComanders) i.next();
                System.out.println("MC " + e.getIdMc() + ", " + e.getNameMc());
            }
 
```
Importando las clases 

![imagen](https://user-images.githubusercontent.com/92187317/167286508-fafd3986-8434-476d-9486-6037c14ddda7.png)

![imagen](https://user-images.githubusercontent.com/92187317/167286484-6ccb859b-2f63-4aae-89b0-f22cf414db0e.png)

Ahora toca construir el proyecto que al hacerlo se generará la carpeta out que contendrá un archivo jar

![imagen](https://user-images.githubusercontent.com/92187317/167286610-73edfdf3-f3e1-4009-9c46-8cf6da1f599a.png)

A partir de ahí podremos crear el archivo Dockerfile para la imagen, pero primero hay que probar el Main que funcione

![imagen](https://user-images.githubusercontent.com/92187317/167286693-dad50839-5fec-43a6-b015-8a8a08128589.png)

Bien! Funciona el Main. Ahora si a generar el archivo Dockerfile

![imagen](https://user-images.githubusercontent.com/92187317/167287042-678260c6-6aa5-4fbd-86a9-e461b5e5a329.png)

Desde CMD ubicarse en la carpeta donde está el Dockerfile y crear la imagen

![imagen](https://user-images.githubusercontent.com/92187317/167287539-8ff09ce5-b96f-48b3-81e0-3816e995fcbd.png)

![imagen](https://user-images.githubusercontent.com/92187317/167287118-7d49bc60-51a0-4ce1-b7b7-0a40f605c1e1.png)

Comprobamos que se haya creado la imagen
![imagen](https://user-images.githubusercontent.com/92187317/167286861-35742041-2897-4fea-a9f5-b1b9198dc837.png)

Corremos la imagen ``` docker run NombredeImagenoIDdeImagen ```

![imagen](https://user-images.githubusercontent.com/92187317/167286908-f00e0cee-f6dd-4671-9556-e4478ce89442.png)

<h2> Listo! 🚀 </h2>

![Felicidad](https://user-images.githubusercontent.com/92187317/167287389-2996adc6-fca4-4afc-9e39-117e9f079ec4.gif)

Fuentes:

https://stackoverflow.com/questions/2025607/how-to-create-a-jar-file-or-export-jar-in-intellij-idea-like-eclipse-java-arch

https://dzone.com/articles/run-simple-jar-application-in-docker-container-1

https://www.youtube.com/watch?v=fqMOX6JJhGo
