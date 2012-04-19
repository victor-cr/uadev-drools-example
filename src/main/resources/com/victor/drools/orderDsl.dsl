[when] Every Order = $o : Order($id:id, $t:time, $items:items, $inPty:inParty)
[when] - which has items = items != null

[when] And every OrderItem = $item : OrderItem($prd:product) from $o.items

[when] Without violations of rule {ruleNumber} = not( Problem(orderId == $id, ruleId == {ruleNumber}) )
[when] Without violations of item rule {ruleNumber} = not( OIProblem(orderId==$id, ruleId=={ruleNumber}, product==$prd) )

[when] Which violates inParty constraints = eval( dao.findPartyBy($t, $inPty) == null )
[when] Which violates product constraints = eval( dao.findProductBy($t, $prd) == null )

[then] Add the violation of the rule {ruleNumber} for order item = log.info("Rule #" + {ruleNumber} + " violated for order: " + $id + " and product: " + $prd); insert(new OIProblem($id, {ruleNumber}, $prd));
[then] Add the violation of the rule {ruleNumber} = log.info("Rule #" + {ruleNumber} + " violated for order: " + $id); insert(new Problem($id, {ruleNumber}));
