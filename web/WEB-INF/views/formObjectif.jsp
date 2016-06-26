<form class="form-horizontal" method="post" action="${action}" role="form">
    <div class="form-group">
        <label class="control-label col-sm-2" for="listeActions">Actions associées à cet objectif</label>
        <div class="col-sm-10">
            <select class="selectpicker form-control" multiple name="listeActions" id="listeActions">
                <c:forEach items="${sessionScope.actions}" var="a">
                    <option value="${a.value.numaction }">${a.value.libaction}</option>
                </c:forEach>
            </select>
            <span>${form.erreurs['listeActions']}</span>
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-sm-2" for="libelle">Libelle</label>
        <div class="col-sm-10">
            <input type="text"
                   class="form-control"
                   id="libelle" name="libelle"
                   value="<c:out value="${objectif.libobectif}"/>"
                   size="20" maxlength="60"
                   placeholder="Entrez le libéllé"
            />
            <span>${form.erreurs['libelle']}</span>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Valider</button>
        </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />

    <p> ${form.erreurs['formulaire']} </p>
    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
</form>