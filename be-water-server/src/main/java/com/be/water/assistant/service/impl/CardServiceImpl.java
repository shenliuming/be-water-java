package com.be.water.assistant.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.be.water.assistant.convert.CardConvert;
import com.be.water.assistant.dao.CardDao;
import com.be.water.assistant.entity.CardEntity;
import com.be.water.assistant.query.CardQuery;
import com.be.water.assistant.service.CardService;
import com.be.water.assistant.vo.CardVO;
import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.impl.BaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卡牌信息表
 *
 * @author shenliuming 597478495@qq.com
 * @since 1.0.0 2024-10-29
 */
@Service
@AllArgsConstructor
public class CardServiceImpl extends BaseServiceImpl<CardDao, CardEntity> implements CardService {

    @Override
    public PageResult<CardVO> page(CardQuery query) {
        IPage<CardEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(CardConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<CardEntity> getWrapper(CardQuery query){
        LambdaQueryWrapper<CardEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(CardVO vo) {
        CardEntity entity = CardConvert.INSTANCE.convert(vo);
        String url = "https://stzb.cbg.163.com/cgi/api/get_equip_detail?client_type=h5";


        Map<String, Object> params = new HashMap<>();
        params.put("serverid", 1);
        params.put("ordersn", "202411151502116-1-YCLNHYEJE51YGK"); // 假设 ordersn 已定义
        params.put("view_loc", "equip_list|tag_key:{\"is_from_ad_reco\": 0, \"tag\": \"user\"}");
        params.put("exter", "direct");
        params.put("page_session_id", "0192D871-6749-197D-DCE5-5A5744DBD4B2");
        params.put("traffic_trace","{\"field_id\":\"f_equip_list\",\"content_id\":\"c_equip_list\"}");
        // 发送 POST 请求
        String response = HttpUtil.post(url, params);

        JSONObject jsonObject = JSON.parseObject(response);
        JSONObject equip = jsonObject.getJSONObject("equip");
        JSONObject equip_desc = equip.getJSONObject("equip_desc");
        JSONArray cards = equip_desc.getJSONArray("card");

        // 遍历 cards 数组
        for (int i = 0; i < cards.size(); i++) {
            JSONObject cardJson = cards.getJSONObject(i);
            CardEntity cardEntity = JSON.parseObject(cardJson.toJSONString(), CardEntity.class);
            baseMapper.insert(cardEntity); // 保存到数据库
        }
//        baseMapper.insert(entity); // 保存到数据库

//        String url = "https://stzb.cbg.163.com/cgi-bin/recommend.py?client_type=h5&view_loc=reco_sim&count=8&serverid=1&act=similar&equips=%5B%5B1%2C%20%22202410171502116-1-N6UJQHFGU1LFAA%22%5D%5D&page=1&exter=direct&page_session_id=0192DC6A-629F-6292-BADD-93344DD4E93B&traffic_trace=%7B%22field_id%22%3A%22f_equip_list%22%2C%22content_id%22%3A%22c_equip_list%22%7D";
//        String response = HttpUtil.get(url);
//        JSONObject jsonObject = JSON.parseObject(response);
//        JSONArray result = jsonObject.getJSONArray ("result");
//
//        result.forEach(item -> {
//            JSONObject jsonItem = (JSONObject) item;
//            JSONObject obj = jsonItem.getJSONObject("other_info");
//            JSONArray cards = obj.getJSONArray("top_cards");
//            cards.forEach(c->{
//                JSONObject object = (JSONObject) c;
//                CardEntity cardEntity = JSON.parseObject(object.toJSONString(), CardEntity.class);
//                baseMapper.insert(cardEntity);
//            });
//        });

//        baseMapper.insert(entity);
    }

    @Override
    public void update(CardVO vo) {
        CardEntity entity = CardConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}