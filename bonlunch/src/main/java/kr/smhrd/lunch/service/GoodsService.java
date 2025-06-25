package kr.smhrd.lunch.service;

import kr.smhrd.lunch.dto.GoodsDTO;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.entity.GoodsDetail;
import kr.smhrd.lunch.repository.GoodsDetailRepository;
import kr.smhrd.lunch.repository.GoodsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
	

    
    @Autowired
    GoodsRepository goodsRepository;

	
	public List<GoodsDTO> getAllGoods() {
		// 1. 데이터 처리
		// 2. repository 호출 < entitiy의 형태
		List<Goods> result = goodsRepository.findAll();
		// 3. Controller 돌려줄 데이터 처리 < Dto의 형태를 사용한다
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		for(Goods g : result) {
			GoodsDTO dto = new GoodsDTO();
			dto.setId(g.getId());
			dto.setName(g.getName());
			dto.setPrice(g.getPrice());
			dto.setIsNew(g.getIsNew());
			dto.setIsBest(g.getIsBest());
			dto.setMain_thumb(g.getMain_thumb());
			list.add(dto);
		}
		
		return list;
	}
	
	@Autowired
	GoodsDetailRepository detailRepository;

	public GoodsDTO getGoodsDetail(int id) {

		// 1. id값을 가지고 제품 정보 Goods 가지고 오기
		Goods goods = goodsRepository.findById(id).orElse(null);
		GoodsDetail detail = detailRepository.findById(id).orElse(null);
		
		// 2. 두 변수의 값이 null인 경우에는 null을 리턴
		if(goods == null || detail == null) {
			return null;
		}
		
		GoodsDTO dto = new GoodsDTO();
		dto.setId(goods.getId());
		dto.setPrice(goods.getPrice());
		dto.setName(goods.getName());
		dto.setIsNew(goods.getIsNew());
		dto.setIsBest(goods.getIsBest());
		dto.setMain_thumb(goods.getMain_thumb());
		dto.setDetail(detail);
		
		return dto;
	}



}
