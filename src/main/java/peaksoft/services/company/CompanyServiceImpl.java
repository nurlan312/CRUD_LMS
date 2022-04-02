package peaksoft.services.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.daos.company.CompanyDao;
import peaksoft.models.Company;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public Company saveCompany(Company company) {
        return companyDao.saveCompany(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }

    @Override
    public Company getByIdCompany(Long id) {
        return companyDao.getByIdCompany(id);
    }

    @Override
    public void updateCompany(Company company, Long id) {
        companyDao.updateCompany(company, id);
    }

    @Override
    public void deleteCompany(Long id) {
        companyDao.deleteCompany(id);
    }
}
