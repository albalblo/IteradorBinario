# IteradorBinario
Toma una string arbitraria de hasta 32 caracteres no especiales (el resto son ignorados) y devuelve un array con todas las posibles comparaciones de mayúsculas y minúsculas

Por ejemplo, el input "Marcos" retorna:
<table>
  <tr><td>marcos</td></tr>
  <tr><td>Marcos</td></tr>
  <tr><td>mArcos</td></tr>
  <tr>MArcos</tr>
  <tr>maRcos</tr>
  <tr>MaRcos</tr>
  <tr>mARcos</tr>
  <tr>MARcos</tr>
  <tr>marCos</tr>
  <tr>MarCos</tr>
  <tr>...</tr>
  <tr>mArCOS</tr>
  <tr>MArCOS</tr>
  <tr>maRCOS</tr>
  <tr>MaRCOS</tr>
  <tr>mARCOS</tr>
  <tr>MARCOS</tr>
</table>
