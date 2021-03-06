package costumetrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import costumetrade.domain.SpPCate;
import costumetrade.domain.SpPCateKey;

import costumetrade.mapper.SpPCateMapper;
import costumetrade.service.SpPCateService;

@Transactional
@Service
public class SpPCateServiceImpl implements SpPCateService{
	@Autowired
	private SpPCateMapper spPCateMapper;
	
	public List<SpPCate> getSpPCates(int cropId) {

		return spPCateMapper.getSpPCates(cropId);
	}
	public int saveSpPCate(SpPCate spPCate) {
		int save = 0;
		//查询对应ID的员工是否存在，存在的话进行update 不存在save
		SpPCateKey spPCateKey = new SpPCateKey();
		if(spPCate.getId() != null && spPCate.getCorpid() != null){
			spPCateKey.setId(spPCate.getId());
			spPCateKey.setCorpid(spPCate.getCorpid());

			SpPCate getCate = spPCateMapper.selectByPrimaryKey(spPCateKey);
			if(getCate != null){
				save = spPCateMapper.updateByPrimaryKeySelective(spPCate);
			}else {
				save = spPCateMapper.insert(spPCate) ;
			}
		}
		 
		
		return save;
		
		 
	}
	public int deleteSpPCate(SpPCateKey spPCateKey) {
	
		return spPCateMapper.deleteByPrimaryKey(spPCateKey);
	}
	
	
	

}
