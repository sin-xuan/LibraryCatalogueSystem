/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author zx
 */
public class BookRepositoryFactory {
    private static final BookRepository REPOSITORY_INSTANCE = createInstance();

    private static BookRepository createInstance() {
        try{
            
            Properties repositoryProperties = new Properties();
            repositoryProperties.loadFromXML(new FileInputStream(new File("repository-settings.properties")));
            return (BookRepository)Class.forName(repositoryProperties.getProperty("repository.implementation.use")).newInstance();         
        }
        catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }
    
    /**
     * Return the class member REPOSITORY_INSTANCE
     *
     * @return the class member REPOSITORY_INSTANCE
     */
    public static BookRepository getInstance() throws Exception
    {
        if (REPOSITORY_INSTANCE != null)
            return REPOSITORY_INSTANCE;
        throw new Exception("Failed to create repository");
    }
}
