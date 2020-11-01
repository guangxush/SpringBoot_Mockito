package com.shgx.mockito.dal;

import com.shgx.mockito.model.AlgorithmDO;
import org.springframework.stereotype.Service;

/**
 * @author: guangxush
 * @create: 2020/11/01
 */
@Service
public class BayesAlgorithmDAL {

    public boolean findResultByKey(String id){
        // 模拟连接数据库并返回值的操作
        return true;
    }
}
