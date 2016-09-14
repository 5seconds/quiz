 $(document).ready(function(){
            $('#Form1').validate({

                rules:{
                       nome:{
                        required:true,
                        minlength:5

                       },
                        email:{
                          required:true,
                          email:true,
                         remote:"view/Usuario/verificarEmail.jsp"
                       },
                        senha:{
                          required:true,
                          rangelength:[5,20]

                       },
                       confsenha:{
                           required:true,
                           equalTo: "#senha"

                       }
                       

                },
                messages:{
                         nome:{
                        required:"Este campo é obrigatório",
                        minlength:"O nome deve conter no mínimo 5 caracteres"

                       },
                        email:{
                          required:"Este campo é obrigatório",
                          email:"Informe um email válido",
                          remote:"Email já cadastrado"
                       },
                        senha:{
                          required:"Este campo é obrigatório",
                          rangelength:"Sua senha deve ter 5 a 20 caracteres"

                       },
                       confsenha:{
                           required:"Esté Campo é obrigatório",
                           equalTo: "As senhas estão diferentes!  "

                       }
                        

                }

            });
    });