package user.service.vtech.userservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import user.service.vtech.userservice.VO.Department;
import user.service.vtech.userservice.VO.ResponseTemplateVO;
import user.service.vtech.userservice.entity.User;
import user.service.vtech.userservice.respository.UserRepository;

@Service
@Slf4j
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        log.info("Executing SaveUser in the service layer");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Executing getUserWithDepartment in the service layer");
        ResponseTemplateVO vo=new ResponseTemplateVO();
        User user=userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://localhost:9091/department/"+user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return  vo;
    }
}
