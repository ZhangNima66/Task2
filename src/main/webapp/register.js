// JavaScript Document
function onblurs(node)
		{
			if(node.value=="")
			{
				var str = '不能为空';
				addTag(str,node);
			}
		}

		function addTag(str,node)
		{
			var input = document.getElementById("sub");
			input.style.cursor='not-allowed';
			input.disabled = true;

			var tab=document.getElementById('tab');
			var n=node.parentNode.parentNode.rowIndex + 1;
			var tr=tab.insertRow(n);
			tr.innerHTML="<td colspan='2' class='error'><div>"+str+"</div></td>";
		}

		function onFocus(node)
		{
			var tab=document.getElementById('tab');
			var n=node.parentNode.parentNode.rowIndex + 1;
			if(tab.rows[n].childNodes[0].className == "error")
			{
				var input = document.getElementById("sub");
				input.style.cursor='pointer';
				input.disabled = false;
				tab.deleteRow(n);
			}
		}