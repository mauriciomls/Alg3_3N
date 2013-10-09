
public class Reta extends Shape {

	Ponto p  = new Ponto();
	Ponto p0 = new Ponto();
	Ponto p1 = new Ponto();
		
	public void draw(Cor cor, Imagem imagem) {
		imagem.setPixel(p0, cor);
		imagem.setPixel(p1, cor);

		int x, y, err, deltaX, deltaY;
		err = 0;
		x = p0.x;
		y = p0.y;
		deltaX = p1.x - p0.x;
		deltaY = p1.y - p0.y;
 
		if ( (  Math.abs(deltaY)>=Math.abs(deltaX) && p0.y > p1.y)
			 || (Math.abs(deltaY)<Math.abs(deltaX) && deltaY<0 ) ) {
			x = p1.x;
			y = p1.y;
			deltaX = p0.x - p1.x;
			deltaY = p0.y - p1.y;
		}
		if ( deltaX>=0 ) {
			if ( Math.abs(deltaX) >= Math.abs(deltaY) ){
				for ( int i = 1; i < Math.abs(deltaX); i++ ){
					if ( err < 0 ){
						x++;
						p.x = x;
						p.y = y;
						imagem.setPixel(p, cor);						
						err += deltaY;
					} else {
						x++;
						y++;
						p.x = x;
						p.y = y;
						imagem.setPixel(p, cor);
						err += deltaY - deltaX;
					}
				}
			} else {
				for ( int i = 1; i < Math.abs(deltaY); i++){
					if ( err < 0 ){
						x++;
						y++;
						p.x = x;
						p.y = y;
						imagem.setPixel(p, cor);
						err += deltaY - deltaX;						
					}else{
						y++;
						p.x = x;
						p.y = y;
						imagem.setPixel(p, cor);
						err -= deltaX;
					}
				}
			}
		} else { 
			if ( Math.abs(deltaX) >= Math.abs(deltaY) ){
				for( int i = 1; i < Math.abs(deltaX); i++ ){
					if(err < 0){
						x--;
						p.x = x;
						p.y = y;
						imagem.setPixel(p, cor);
						err += deltaY;
					}else{
						x--;
						y++;
						p.x = x;
						p.y = y;
						imagem.setPixel(p, cor);
						err += deltaY + deltaX;
					}
				}
			} else {
				for( int i=1; i < Math.abs(deltaY); i++ ){
					if ( err < 0 ){
						x--;
						y++;
						p.x = x;
						p.y = y;
						imagem.setPixel(p, cor);
						err += deltaY + deltaX;						
					} else {
						y++;						
						p.x = x;
						p.y = y;
						imagem.setPixel(p, cor);
						err += deltaX;
					}
				}
			}
		}
	}

	public void setPonto(int x0, int y0, int x1, int y1){
		this.p0.x = x0;
		this.p0.y = y0;
		this.p1.x = x1;
		this.p1.y = y1;			
	}

}