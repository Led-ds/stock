<div id="mark" ng-controller="markController">
		<fieldset class="form-group">
		    <legend>MARKS</legend>
			<form name="form" novalidate>
				
				<div class="row">
					<div class="col-sm-3 form-group">
					    <input type="text" class="form-control" ng-model="mark.id" readonly="readonly" name="markId" disabled="disabled">
					</div>
				</div>			
				
				<div class="row">
					<div class="col-sm-3 form-group">
						<label>Codigo</label>
				   		<input type="text" class="form-control" ng-model="mark.code" placeholder="code">
					</div>
					
					<div class="col-sm-3 form-group">
						<label>Nome</label>
				   		<input type="text" class="form-control" ng-model="mark.name" placeholder="name" required>
				   		<p class="help-block" ng-if="form.name.$error.required">Nome &eacute; obrigat&oacute;rio!</p>
					</div>
						
				</div>
			    
			  	<button type="button" class="btn btn-default" name="mark" ng-click="save(mark);">
			  	</button>
			</form>
		</fieldset>
</div>