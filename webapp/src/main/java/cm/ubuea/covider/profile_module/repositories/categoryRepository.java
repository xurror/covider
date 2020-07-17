package cm.ubuea.covider.profile_module.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.ubuea.covider.profile_module.models.Category;

/**
 *
 * @author collins
 */
public interface categoryRepository extends JpaRepository<Category, Long> {

    //public Category saveAndFlush (Long id);
    
}