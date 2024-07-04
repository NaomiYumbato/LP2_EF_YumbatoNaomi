package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.CategoriaEntity;
import com.example.demo.entity.ProductoEntity;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.ProductoService;
import com.example.demo.service.impl.PdfService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private PdfService pdfService;
	

	@GetMapping("/menu_productos")
	public String showMenu(HttpSession session, Model model) {
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		} 
		List<ProductoEntity>productos = productoService.findAllProductos();
		model.addAttribute("lstProd", productos);
											
		return "menu_productos";
	}
	
	@GetMapping("/registrarProd")
	public String viewRegistrarProducto(Model model) {
		model.addAttribute("prod", new ProductoEntity());
		List<CategoriaEntity> listCat = categoriaService.findAllCategorias();
		model.addAttribute("listCat", listCat);
		return "registrar_producto";
	}
	
	@PostMapping("/registrarProd")
	public String registrarProducto(ProductoEntity productoEntity, Model model) {
		
		productoService.registrarProducto(productoEntity, model);
		
		return "registrar_producto";
	}
	
	@GetMapping("/editarProd/{idProducto}")
	public String viewEditarProducto(Model model, @PathVariable("idProducto") Integer idProducto) {
		ProductoEntity prodEncotrado = productoService.buscarProductoPorId(idProducto);
		List<CategoriaEntity> listCat = categoriaService.findAllCategorias();
		model.addAttribute("listCat", listCat);
		model.addAttribute("prod", prodEncotrado);
		return "editar_producto";
	}
	
	@PostMapping("/editarProd")
	public String actualizarEmpleado(ProductoEntity prod, Model model) {
		List<CategoriaEntity> listCat = categoriaService.findAllCategorias();
		model.addAttribute("listCat", listCat);
		productoService.editarProducto(prod, model);
		return "redirect:/menu_productos";
	}
	
	@GetMapping("/verProd/{idProducto}")
	public String viewVerProducto(Model model, @PathVariable("idProducto") Integer idProducto) {
		ProductoEntity prodEncotrado = productoService.buscarProductoPorId(idProducto);
		List<CategoriaEntity> listCat = categoriaService.findAllCategorias();
		model.addAttribute("listCat", listCat);
		model.addAttribute("prod", prodEncotrado);
		return "ver_producto";
	}
	
	@GetMapping("/eliminarProd/{idProducto}")
	public String eliminarProd(@PathVariable("idProducto") Integer idProducto) {
		productoService.eliminarProducto(idProducto);
		return "redirect:/menu_productos";
	}
	
	@GetMapping("/generar_pdf")
	 public ResponseEntity<InputStreamResource> geneararPdf(HttpSession session) throws IOException{
        List<ProductoEntity> lstProductos = productoService.findAllProductos();

        Map<String,Object> datosPdf= new HashMap<String, Object>();
        datosPdf.put("lstProductos", lstProductos);

        ByteArrayInputStream pdfBytes = pdfService.generarPdfDeHtml("template_pdf", datosPdf);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "inline; filename=ListaProductos.pdf");

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdfBytes));
    }
}
