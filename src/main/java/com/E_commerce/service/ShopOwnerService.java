
package com.E_commerce.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import com.E_commerce.Repository.shopOwnerRepository;
//
//import com.E_commerce.model.shop_owner;
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//public class ShopOwnerService {
//
//    @Autowired
//    private shopOwnerRepository rep;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public void ownerRegistration(shop_owner sh) {
//    	sh.setPassword(passwordEncoder.encode(sh.getPassword()));
//        rep.save(sh);
//    }
//
//    public List<shop_owner> getAllShopOwners() {
//        return rep.findAll();
//    }
//
//    public void approveShopOwner(int ownerId) {
//        shop_owner owner = rep.findById(ownerId).orElseThrow();
//        owner.setApproved(true);
//        rep.save(owner);
//    }
//
//    public void rejectShopOwner(int ownerId) {
//        rep.deleteById(ownerId);
//    }
//    public shop_owner findByEmailAndPassword(String email, String password) {
//        Optional<shop_owner> userOpt = rep.findByEmail(email);
//        if (userOpt.isPresent()) {
//            shop_owner user = userOpt.get();
//            if (passwordEncoder.matches(password, user.getPassword())) {
//                return user;
//            }
//        }
//        return null;
//    }
//    public shop_owner findByEmail(String email) {
//        return rep.findByEmail(email).orElse(null);
//    }




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.E_commerce.Repository.shopOwnerRepository;
import com.E_commerce.model.shop_owner;
import java.util.List;
import java.util.Optional;

@Service
public class ShopOwnerService {

    @Autowired
    private shopOwnerRepository rep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void ownerRegistration(shop_owner sh) {
       // sh.setPassword(passwordEncoder.encode(sh.getPassword()));
        rep.save(sh);
    }

    public List<shop_owner> getAllShopOwners() {
        return rep.findAll();
    }

    public void approveShopOwner(int ownerId) {
        shop_owner owner = rep.findById(ownerId).orElseThrow();
        owner.setApproved(true);
        rep.save(owner);
    }

    public void rejectShopOwner(int ownerId) {
        rep.deleteById(ownerId);
    }

    public shop_owner findByEmail(String email) {
        Optional<shop_owner> userOpt = rep.findByEmail(email);
        return userOpt.orElse(null);
    }

    public shop_owner findByEmailAndPassword(String email, String password) {
        Optional<shop_owner> userOpt = rep.findByEmail(email);
        if (userOpt.isPresent()) {
            shop_owner user = userOpt.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
//    public shop_owner findById(Integer id) {
//        return rep.findById(id).orElseThrow(() -> new RuntimeException("Shop Owner not found"));
//}
    public shop_owner findByLoginId(Integer loginId) {
        return rep.findByLogin_Id(loginId)
                .orElseThrow(() -> new RuntimeException("Shop Owner not found for loginId: " + loginId));
    }

}


	


