package com.fourcatsdev.aula08.controller;

import com.fourcatsdev.aula08.modelo.Papel;
import com.fourcatsdev.aula08.modelo.Usuario;
import com.fourcatsdev.aula08.repository.PapelRepository;
import com.fourcatsdev.aula08.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PapelRepository papelRepository;

    @Autowired
    private BCryptPasswordEncoder criptografia;


    /**
     * Método que verifica qual papel o usuário tem na aplicação
     * */
    private boolean temAutorizacao(Usuario usuario, String papel) {
        for (Papel pp : usuario.getPapeis()) {
            if (pp.getPapel().equals(papel)) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/index")
    public String index(@CurrentSecurityContext(expression="authentication.name")
                        String login){


        Usuario usuario = usuarioRepository.findByLogin(login);

        String redirectURL = "";
        if (temAutorizacao(usuario, "ADMIN")) {
            redirectURL = "/auth/admin/publica-index";
        } else if (temAutorizacao(usuario, "USER")) {
            redirectURL = "/auth/user/publica-index";
        }

       return redirectURL;
    }




    @GetMapping("/novo")
    public String adicionarUsuario(Model model){

        model.addAttribute("usuario", new Usuario());
        //return "/auth/user/publica-criar-usuario";
         return "/publica-criar-usuario";

    }

    @PostMapping("/salvar")
    public String salvarUsuario(@Valid Usuario usuario, BindingResult result, Model model,
                                RedirectAttributes attributes) {
        if (result.hasErrors()) {
          // return "/auth/user/publica-criar-usuario";
            return "/publica-criar-usuario";

        }

        Usuario usr = usuarioRepository.findByLogin(usuario.getLogin());
        if (usr != null) {
            model.addAttribute("loginExiste", "Login já existe cadastrado");
            //return "/auth/user/publica-criar-usuario";
            return "/publica-criar-usuario";
        }

        //Busca o papel básico de usuário
        Papel papel = papelRepository.findByPapel("USER");
        List<Papel> papeis = new ArrayList<Papel>();
        papeis.add(papel);
        usuario.setPapeis(papeis); // associa o papel de USER ao usuário

        String senhaCriptografia = criptografia.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptografia);


        usuarioRepository.save(usuario);
        attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
        return "redirect:/usuario/novo";

    }

    @RequestMapping("/admin/listar")
    public String listarUsuario(Model model) {

        model.addAttribute("usuarios", usuarioRepository.findAll());
       return "/auth/admin/admin-listar-usuario";


    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable("id") long id, Model model) {
        Optional<Usuario> usuarioVelho = usuarioRepository.findById(id);
        if (!usuarioVelho.isPresent()) {
            throw new IllegalArgumentException("Usuário inválido:" + id);
        }
        Usuario usuario = usuarioVelho.get();
        model.addAttribute("usuario", usuario);
        return "/auth/user/user-alterar-usuario";
    }

    @PostMapping("/editar/{id}")
    public String editarUsuario(@PathVariable("id") long id,
                                @Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            usuario.setId(id);
            return "/auth/user/user-alterar-usuario";
        }
        usuarioRepository.save(usuario);
        return "redirect:/usuario/admin/listar";
    }

    @GetMapping("/editarPapel/{id}")
    public String selecionarPapel(@PathVariable("id") long id, Model model) {

        Optional<Usuario> usuarioVelho = usuarioRepository.findById(id);

        if (!usuarioVelho.isPresent()) {

            throw new IllegalArgumentException("Usuário inválido:" + id);

        }

        Usuario usuario = usuarioVelho.get();
        model.addAttribute("usuario", usuario);

        model.addAttribute("listaPapeis", papelRepository.findAll());

        return "/auth/admin/admin-editar-papel-usuario";



    }


    @PostMapping("/editarPapel/{id}")
    public String atribuirPapel(@PathVariable("id") long idUsuario,
                                @RequestParam(value = "pps", required=false) int[] pps,
                                Usuario usuario,
                                RedirectAttributes attributes) {
        if (pps == null) {
            usuario.setId(idUsuario);
            attributes.addFlashAttribute("mensagem", "Pelo menos um papel deve ser informado");
            return "redirect:/usuario/editarPapel/"+idUsuario;
        } else {
            //Obtém a lista de papéis selecionada pelo usuário do banco
            List<Papel> papeis = new ArrayList<Papel>();
            for (int i = 0; i < pps.length; i++) {
                long idPapel = pps[i];
                Optional<Papel> papelOptional = papelRepository.findById(idPapel);
                if (papelOptional.isPresent()) {
                    Papel papel = papelOptional.get();
                    papeis.add(papel);
                }
            }
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
            if (usuarioOptional.isPresent()) {
                Usuario usr = usuarioOptional.get();
                usr.setPapeis(papeis); // relaciona papéis ao usuário
                usr.setAtivo(usuario.isAtivo());
                usuarioRepository.save(usr);
            }
        }
        return "redirect:/usuario/admin/listar";
    }

    @GetMapping("/admin/apagar/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
        usuarioRepository.delete(usuario);
        return "redirect:/usuario/admin/listar";
    }


}
