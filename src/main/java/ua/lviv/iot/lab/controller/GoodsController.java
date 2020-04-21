package ua.lviv.iot.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.lab.business.GoodsService;
import ua.lviv.iot.lab.model.Pen;

@RequestMapping("/goods")
@RestController
public class GoodsController {

  @Autowired
  private GoodsService goodsService;

  @GetMapping
  public List<Pen> getGoods() {
    return goodsService.getGoods();
  }

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<Pen> getGood(final @PathVariable("id") Integer goodId,
      Pen good) {

    ResponseEntity<Pen> status = (good = goodsService.getGood(goodId)) == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(good, HttpStatus.OK);
    return status;
  }

  @PostMapping
  public Pen createGood(final @RequestBody Pen good) {

    return goodsService.createGoods(good);
  }

  @DeleteMapping(path = { "/{id}" })
  public ResponseEntity<Pen> deleteGood(@PathVariable("id") Integer goodId) {
    HttpStatus status = goodsService.deleteGood(goodId) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
    return ResponseEntity.status(status).build();
  }

  @PutMapping(path = { "/{id}" })
  public ResponseEntity<Pen> updateGood(final @PathVariable("id") Integer goodId,
      final @RequestBody Pen good) {
    good.setId(goodId);
    Pen updatedGood = goodsService.updateGood(goodId, good);
    ResponseEntity<Pen> status = updatedGood == null
        ? new ResponseEntity<Pen>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<Pen>(HttpStatus.OK);
    return status;
  }
}