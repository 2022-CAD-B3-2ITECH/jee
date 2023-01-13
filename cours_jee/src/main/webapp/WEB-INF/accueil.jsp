<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>

	<c:if test="${ !empty erreur }">
		<p style="color: red;">
			<c:out value="${ erreur }" />
		</p>
	</c:if>

	<form method="post" action="">

		<p>
			<label for="prenom">Prénom :</label> <input type="text" id="prenom"
				name="prenom" />
		</p>
		<p>
			<label for="nom">Nom :</label> <input type="text" id="nom" name="nom" />
		</p>

		<input type="submit" />

	</form>

	<ul>
		<c:forEach items="${ utilisateurs }" var="utilisateur">

			<li><c:out value="${ utilisateur.prenom } ${ utilisateur.nom }"></c:out>
		</c:forEach>
	</ul>

</body>
</html>