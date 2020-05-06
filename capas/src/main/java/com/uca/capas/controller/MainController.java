package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;

@Controller
public class MainController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0, "Apocalipsis", 50));
		productos.add(new Product(1, "Torre oscura", 20));
		productos.add(new Product(2, "Pinocchio", 35));
		productos.add(new Product(3, "El alquimista", 34));
		productos.add(new Product(4, "It, el payaso", 54));
		
		mav.setViewName("select");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		return mav;
		
	}
	
	public String res;
	@PostMapping("/validar")
	@ResponseBody
	
	public String validar( Product product) {
		//return productos.get(product.getId()).getNombre();
		if (product.getCantidad() >productos.get(product.getId()).getCantidad()) {
			 res=	 productos.get(product.getId()).getNombre() + " no está disponible";

		}else {
			 res=	 productos.get(product.getId()).getNombre() + " Está disponible";
		}
		return res;
	}

}
