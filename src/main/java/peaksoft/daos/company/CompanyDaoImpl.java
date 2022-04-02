package peaksoft.daos.company;

import org.springframework.stereotype.Repository;
import peaksoft.models.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository @Transactional
public class CompanyDaoImpl implements CompanyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Company saveCompany(Company company) {
        entityManager.persist(company);
        return company;
    }

    @Override
    public List<Company> getAllCompanies() {
        return entityManager.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public Company getByIdCompany(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void updateCompany(Company company, Long id) {
        Company company1 = getByIdCompany(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        entityManager.merge(company1);
    }

    @Override
    public void deleteCompany(Long id) {
        entityManager.remove(getByIdCompany(id));
    }
}
