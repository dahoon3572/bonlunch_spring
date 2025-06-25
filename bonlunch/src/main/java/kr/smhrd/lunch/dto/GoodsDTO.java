package kr.smhrd.lunch.dto;

import jakarta.persistence.Id;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.entity.GoodsDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDTO {

	private Integer id;
	private String name;
	private String price;
	private Boolean isNew;
	private Boolean isBest;
	private String main_thumb;
	
	// GoodsDetail 물품의 상세 정보 객체도
	
	private GoodsDetail detail;
	// React에서 이중 객체의 형태로 반환하기를 바라기 때문에
	
//	public static GoodsDTO formEntity(Goods goods) {
//		return GoodsDTO.builder()
//				.id(goods.getId())
//				.isBest(goods.getIsBest())
//				.isNew(goods.getIsNew())
//				.main_thumb(goods.getMain_thumb())
//				.name(goods.getName())
//				.price(goods.getPrice())
//				.build();
//	}
}
