package pl.dmcs.rkotas.service;

import jakarta.servlet.http.HttpServletResponse;
import pl.dmcs.rkotas.domain.AppUser;

public interface PdfService {
    public void generatePdf(AppUser appUser, HttpServletResponse response);
}




