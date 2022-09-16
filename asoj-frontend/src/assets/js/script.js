window.onload=function () {
  let as=document.getElementsByClassName('content-header')[0].getElementsByTagName('a');
  let contents=document.getElementsByClassName("dom");
  for (let i=0;i<as.length;i++){
    let a=as[i];
    a.id=i;
    // 设置每个a标签的onclick事件
    a.onclick=function () {
      // 清楚所有标签的css设置，隐藏dom标签
      for(let j=0;j<as.length;j++){
        as[j].className="";
        contents[j].style.display="none";
      }
      // 设置当前标签样式及当前标签下的所有dom标签可见
      this.className='current';
      // 当前div可见
      contents[this.id].style.display='block';
    }
  }
}
