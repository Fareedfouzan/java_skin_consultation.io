
package com.mycompany.person;

import java.io.IOException;
import java.text.ParseException;
/**
 *
 * @author fareedkhan
 */
public interface SkinConsultationManager {

    //Interface methods
    void AddDoctor(Doctor d);
    void printDoctor();
    void DeleteDoctor(int medicLicenseNo);
    void SaveDoctor(Doctor doctor) throws IOException;
    void LoadDoctor();
    boolean RunMenu() throws ParseException, IOException;
}
