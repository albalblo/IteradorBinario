# IteradorBinario
Toma una string arbitraria de hasta 32 caracteres no especiales (el resto son ignorados) y devuelve un array con todas las posibles comparaciones de mayúsculas y minúsculas.

Por ejemplo, el input "Marcos" retorna:
<table>
  <td>Input: "a.nA"</td><td>Input: "Marcos"</td><td>Input: "ç "</td><td>Input: "."</td>
  <tr><td>a.na</td><td>marcos</td><td>ç </td><td>.</td></tr>
  <tr><td>A.na</td><<td>Marcos</td>td>Ç </td></tr>
  <tr><td>a.Na</td><td>mArcos</td></tr>
  <tr><td>A.Na</td><td>MArcos</td></tr>
  <tr><td>a.nA</td><td>maRcos</td></tr>
  <tr><td>A.nA</td><td>MaRcos</td></tr>
  <tr><td>a.NA</td><td>mARcos</td></tr>
  <tr><td>A.NA</td><td>MARcos</td></tr>
  <tr><td></td><td>marCos</td></tr>
  <tr><td></td><td>MarCos</td></tr>
  <tr><td></td><td>...</td></tr>
  <tr><td></td><td>mArCOS</td></tr>
  <tr><td></td><td>MArCOS</td></tr>
  <tr><td></td><td>maRCOS</td></tr>
  <tr><td></td><td>MaRCOS</td></tr>
  <tr><td></td><td>mARCOS</td></tr>
  <tr><td></td><td>MARCOS</td></tr>
</table>
