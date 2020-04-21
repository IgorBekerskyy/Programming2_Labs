package ua.lviv.iot.lab.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.lab.dataaccess.GoodsRepository;
import ua.lviv.iot.lab.model.Pen;

@Service
public class GoodsService {

  @Autowired
  private GoodsRepository goodsRepository;

  public List<Pen> getGoods() {
    return goodsRepository.findAll();
  }

  public Pen getGood(Integer id) {
    if (goodsRepository.existsById(id)) {
      return goodsRepository.findById(id).get();
    } else {
      return null;
    }
  }

  public Pen createGoods(Pen good) {
    return goodsRepository.save(good);
  }

  public boolean deleteGood(Integer id) {
    if (goodsRepository.existsById(id)) {
      goodsRepository.deleteById(id);
      return true;
    } else {
      return false;
    }

  }

  public Pen updateGood(Integer id, Pen good) {
    if (goodsRepository.existsById(id)) {
      Pen updatedGood = goodsRepository.findById(id).get();
      goodsRepository.save(good);
      return updatedGood;
    } else {
      return null;
    }
  }
}