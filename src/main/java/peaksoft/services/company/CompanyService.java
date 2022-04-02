package peaksoft.services.company;

import peaksoft.models.Company;

import java.util.List;

public interface CompanyService {

    Company saveCompany(Company company);

    List<Company> getAllCompanies();

    Company getByIdCompany(Long id);

    void updateCompany(Company company, Long id);

    void deleteCompany(Long id);
}
