package kr.smhrd.lunch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.smhrd.lunch.dto.GoodsDTO;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.service.GoodsService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class GoodsController {
	
	// 서비스 클래스 불러오기
	@Autowired
	GoodsService goodsService;
	
	@GetMapping("/goods_list/{id}")
	public GoodsDTO getGoodsDetail(@PathVariable("id") int id) {
		
		System.out.println("[detail 출력 컨트롤러]");
		System.out.println(id);
		GoodsDTO goodsDetail = goodsService.getGoodsDetail(id);
		
		return goodsDetail;
	}

	@GetMapping("/goods_list")
	public List<GoodsDTO> getGoodsList() {
		System.out.println("[list 출력 컨트롤러]");
		
		// 2Step -> Service -> Repository
		List<GoodsDTO> list = goodsService.getAllGoods();
//		System.out.println(list);
		
		return list;
	}
}
