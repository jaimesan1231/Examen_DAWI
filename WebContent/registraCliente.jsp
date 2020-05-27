<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<title>Registra cliente</title>
</head>
<body>

<div class="container">
<h1>Registra Cliente</h1>
	
	<c:if test="${sessionScope.MENSAJE != null }">
			<div class="alert alert-success" id="success-alert">
	 		   <button type="button" class="close" data-dismiss="alert">x</button>
				${sessionScope.MENSAJE}				
			</div>
	</c:if>
	<c:remove var="MENSAJE"/>

	<form action="registraCliente" id="id_form"> 
			<input type="hidden" name="metodo" value="registra">	
			<div class="form-group">
				<label class="control-label" for="id_nombre">Nombre</label>
				<input class="form-control" type="text" id="id_nombre" name="cliente.nomCliente" placeholder="Ingrese el nombre">
			</div>
			<div class="form-group">
				<label class="control-label" for="id_apellido">Apellido</label>
				<input class="form-control" type="text" id="id_apellido" name="cliente.apeCliente" placeholder="Ingrese el apellido">
			</div>
			<div class="form-group">
				<label class="control-label" for="id_dni">DNI</label>
				<input class="form-control" type="text" id="id_dni" name="cliente.dniCliente" placeholder="Ingrese el dni">
			</div>
			<div class="form-group">
				<label class="control-label" for="id_fecha">Fecha Nacimiento</label>
				<input class="form-control" type="text" id="id_fecha" name="cliente.fecNac" placeholder="Ingrese la fecha de nacimiento">
			</div>
			<div class="form-group">
				<label class="control-label" for="id_tipo">Tipo</label>
				<select id="id_tipo" name="cliente.tipo.idTipo" class='form-control'>
					<option value=" ">[Seleccione]</option>    
				</select>
		    </div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary" >Crea Producto</button>
			</div>
	</form>
</div>

<script type="text/javascript">
$("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
    $("#success-alert").slideUp(500);
});
</script>

<script type="text/javascript">
	$.getJSON("cargaTipo",{}, function(data,q,txt){
		$.each(data.lstTipo, function(key,value){
			$("#id_tipo").append("<option value='" + value.idTipo +  "'>" + value.nomTipo + "</option>")
		})
	});
</script>
	
<script type="text/javascript">
$(document).ready(function() {
    $('#id_form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	nombre: {
        		selector :"#id_nombre",
        		validators: {
                    notEmpty: {
                        message: 'El nombre es un campo obligatorio'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z·ÈÌÛ˙¡…Õ”⁄ÒN	]{3,40}$/,
                        message: 'El nombre debe tener de 3 a 40 letras'
                    }
                }
            },
        	apellido: {
        		selector :"#id_apellido",
                validators: {
                    notEmpty: {
                        message: 'El apellido es un campo obligatorio'
                    },
                    regexp: {
                    	regexp: /^[a-zA-Z·ÈÌÛ˙¡…Õ”⁄ÒN]{3,40}$/,
                        message: 'El nombre debe tener de 3 a 40 letras'
                    }
                }
            },
            dni: {
            	selector :"#id_dni",
                validators: {
                    notEmpty: {
                        message: 'El dni es un campo obligatorio'
                    },
                    regexp: {
                        regexp: /^[0-9]{8}$/,
                        message: 'El DNI debe tener 8 digitos'
                    }
                }
            },
            fecha: {
            	selector :"#id_fecha",
                validators: {
                    notEmpty: {
                        message: 'La Fecha es un campo obligatorio'
                    },
                    date: {
                        format: 'YYYY-MM-DD',
                        message: 'El formato de la fecha es YYYY-MM-DD'
                    }
                }
            },
            tipo: {
            	selector :"#id_tipo",
                validators: {
                    notEmpty: {
                        message: 'El tipo es un campo obligatorio'
                    }
                }
            },
          
        }   
    });

    // Validate the form manually
    $('#validateBtn').click(function() {
        $('#id_form').bootstrapValidator('validate');
    });
});
</script>


</body>
</html>




