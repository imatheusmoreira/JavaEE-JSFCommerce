package br.edu.ifce.bean;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.ProdutoDao;
import br.edu.ifce.model.Produto;

@ManagedBean
public class ProdutoBean {

	ProdutoDao produtoDao = new ProdutoDao();

	private Long id;
	public Long codigo;
	private String descricao;
	private BigDecimal valor;
	private String foto;
	
	private String idProdutoEditado;
	Produto produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getIdProdutoEditado() {
		return idProdutoEditado;
	}

	public void setIdProdutoEditado(String idProdutoEditado) {
		this.idProdutoEditado = idProdutoEditado;
	}

	public List<Produto> listar() {
		return produtoDao.findAll();
	}
	
	public Produto getProdutoEditado() {
		return produto;
	}
	
    public String comprarProdutoPorId() {
        idProdutoEditado = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idSelecionado");
        produto = produtoDao.getById(Long.parseLong(idProdutoEditado));
        return "comprar.jsf";
    }

}
