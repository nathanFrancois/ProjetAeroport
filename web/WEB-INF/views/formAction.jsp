<form class="form-horizontal" method="post" action="${action}" role="form">
    <div class="form-group">
        <label class="control-label col-sm-2" for="listeActions">Action précédente</label>
        <div class="col-sm-10">
            <select class="selectpicker form-control" name="listeActions" id="listeActions">
                <option value="" selected="selected"></option>
                <c:forEach items="${sessionScope.actions}" var="a">
                    <option value="${a.value.numaction }">${a.value.libaction}</option>
                </c:forEach>
            </select>
            <span>${form.erreurs['listeActions']}</span>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-2" for="score">Score Minimum</label>
        <div class="col-sm-10">
            <input type="number"
                   class="form-control"
                   id="score" name="score"
                   value="<c:out value="${actionApp.scoremin}"/>"
                   placeholder="Entrez le score minimum "/>
            <span>${formu.erreurs['score']}</span>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="libelle">Libelle</label>
        <div class="col-sm-10">
            <input type="text"
                   class="form-control"
                   id="libelle" name="libelle"
                   value="<c:out value="${actionApp.libaction}"/>"
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