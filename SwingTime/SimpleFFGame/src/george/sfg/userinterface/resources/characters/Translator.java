p a c k a g e   s m l ;  
  
 i m p o r t   j a v a . i o . I O E x c e p t i o n ;  
 i m p o r t   j a v a . l a n g . r e f l e c t . C o n s t r u c t o r ;  
 i m p o r t   j a v a . l a n g . r e f l e c t . I n v o c a t i o n T a r g e t E x c e p t i o n ;  
 i m p o r t   j a v a . n i o . f i l e . F i l e s ;  
 i m p o r t   j a v a . n i o . f i l e . P a t h s ;  
 i m p o r t   j a v a . u t i l . A r r a y L i s t ;  
 i m p o r t   j a v a . u t i l . A r r a y s ;  
 i m p o r t   j a v a . u t i l . L i s t ;  
 i m p o r t   j a v a . u t i l . s t r e a m . C o l l e c t o r s ;  
  
 / *  
   *   T h e   t r a n s l a t o r   o f   a   < b > S < / b > < b > M < / b > a l < b > L < / b >   p r o g r a m .  
   * /  
 p u b l i c   c l a s s   T r a n s l a t o r   {  
  
         / /   w o r d   +   l i n e   i s   t h e   p a r t   o f   t h e   c u r r e n t   l i n e   t h a t ' s   n o t   y e t   p r o c e s s e d  
         / /   w o r d   h a s   n o   w h i t e s p a c e  
         / /   I f   w o r d   a n d   l i n e   a r e   n o t   e m p t y ,   l i n e   b e g i n s   w i t h   w h i t e s p a c e  
         p r i v a t e   S t r i n g   l i n e   =   " " ;  
         p r i v a t e   S t r i n g   f i l e N a m e ;   / /   s o u r c e   f i l e   o f   S M L   c o d e  
  
         p r i v a t e   s t a t i c   f i n a l   S t r i n g   S R C   =   " s r c " ;  
  
         p u b l i c   T r a n s l a t o r ( S t r i n g   f i l e N a m e )   {  
                 t h i s . f i l e N a m e   =   f i l e N a m e ;  
         }  
  
         / /   t r a n s l a t e   t h e   s m a l l   p r o g r a m   i n   t h e   f i l e   i n t o   l a b   ( t h e   l a b e l s )   a n d  
         / /   p r o g   ( t h e   p r o g r a m )  
         / /   r e t u r n   " n o   e r r o r s   w e r e   d e t e c t e d "  
         p u b l i c   b o o l e a n   r e a d A n d T r a n s l a t e ( L a b e l s   l a b ,   A r r a y L i s t < I n s t r u c t i o n >   p r o g )   {  
                 l a b . r e s e t ( ) ;  
                 p r o g . c l e a r ( ) ;  
                 t r y   {  
                         / /   E a c h   i t e r a t i o n   p r o c e s s e s   l i n e   a n d   r e a d s   t h e   n e x t   l i n e   i n t o   l i n e  
                         F i l e s . l i n e s ( P a t h s . g e t ( S R C ,   f i l e N a m e ) ) . f o r E a c h ( l i n e   - >   {  
                                 t h i s . l i n e   =   l i n e ;  
                                 S t r i n g   l a b e l   =   l i n e . s p l i t ( "   " ) [ 0 ] ;  
                                 i f   ( l a b e l . l e n g t h ( )   >   0 )   {  
                                         I n s t r u c t i o n   i n s   =   g e t I n s t r u c t i o n ( g e t I n s t r u c t i o n T y p e ( ) ) ;  
                                         i f   ( i n s   ! =   n u l l )   {  
                                                 l a b . a d d L a b e l ( l a b e l ) ;  
                                                 p r o g . a d d ( i n s ) ;  
                                         }  
                                 }  
                         } ) ;  
                 }   c a t c h   ( I O E x c e p t i o n   e )   {  
                         S y s t e m . o u t . p r i n t l n ( " F i l e :   I O   e r r o r   t o   s t a r t   "   +   e . g e t M e s s a g e ( ) ) ;  
                         r e t u r n   f a l s e ;  
                 }  
                 r e t u r n   t r u e ;  
         }  
  
         / /   l i n e   s h o u l d   c o n s i s t   o f   a n   M M L   i n s t r u c t i o n ,   w i t h   i t s   l a b e l   a l r e a d y  
         / /   r e m o v e d .   T r a n s l a t e   l i n e   i n t o   a n   i n s t r u c t i o n   w i t h   l a b e l   l a b e l  
         / /   a n d   r e t u r n   t h e   i n s t r u c t i o n  
         p u b l i c   I n s t r u c t i o n   g e t I n s t r u c t i o n ( S t r i n g   t y p e )   {  
                 i f   ( l i n e . e q u a l s ( " " ) )   r e t u r n   n u l l ;  
                 t r y   {  
                         C l a s s < ? >   c l a z z   =   C l a s s . f o r N a m e ( g e t C l a s s N a m e ( t y p e ) ) ;  
                         C l a s s < ? > [ ]   p a r a m e t e r L i s t   =   g e t P a r a m e t e r T y p e s ( c l a z z . g e t D e c l a r e d C o n s t r u c t o r s ( ) [ 0 ] ) ;  
                         r e t u r n   ( I n s t r u c t i o n )   c l a z z . g e t D e c l a r e d C o n s t r u c t o r ( p a r a m e t e r L i s t ) . n e w I n s t a n c e ( A r r a y s . s t r e a m ( p a r a m e t e r L i s t )  
                                         . m a p ( p a r a m   - >   p a r a m . i s P r i m i t i v e ( )   ?   u n S h i f t I n t ( )   :   u n S h i f t W o r d ( ) ) . t o A r r a y ( ) ) ;  
                 }   c a t c h   ( C l a s s N o t F o u n d E x c e p t i o n   |   N o S u c h M e t h o d E x c e p t i o n   |   I l l e g a l A c c e s s E x c e p t i o n   |  
                                 I n v o c a t i o n T a r g e t E x c e p t i o n   |   I n s t a n t i a t i o n E x c e p t i o n   e )   {  
                         S y s t e m . o u t . p r i n t l n ( " H o l y   C r a p !   C a n ' t   f i n d   "   +   e . g e t M e s s a g e ( ) ) ;  
                 }  
                 r e t u r n   n u l l ;  
         }  
  
         / *  
           *   R e t u r n   t h e   f i r s t   w o r d   o f   l i n e   a n d   r e m o v e   i t   f r o m   l i n e .   I f   t h e r e   i s   n o  
           *   w o r d ,   r e t u r n   " "  
           * /  
         p u b l i c   S t r i n g   u n S h i f t W o r d ( )   {  
                 l i n e   =   l i n e . t r i m ( ) ;  
                 i f   ( l i n e . l e n g t h ( )   = =   0 )   r e t u r n   " " ;  
                 L i s t < S t r i n g >   w o r d s   =   A r r a y s . s t r e a m ( l i n e . s p l i t ( "   " ) ) . c o l l e c t ( C o l l e c t o r s . t o L i s t ( ) ) ;  
                 S t r i n g   w o r d   =   w o r d s . r e m o v e ( 0 ) ;  
                 l i n e   =   w o r d s . s t r e a m ( ) . c o l l e c t ( C o l l e c t o r s . j o i n i n g ( "   " ) ) ;  
                 r e t u r n   w o r d ;  
         }  
  
         / /   R e t u r n   t h e   f i r s t   w o r d   o f   l i n e   a s   a n   i n t e g e r .   I f   t h e r e   i s  
         / /   a n y   e r r o r ,   r e t u r n   t h e   m a x i m u m   i n t  
         p u b l i c   i n t   u n S h i f t I n t ( )   {  
                 S t r i n g   w o r d   =   u n S h i f t W o r d ( ) ;  
                 i f   ( w o r d . l e n g t h ( )   = =   0 )   r e t u r n   I n t e g e r . M A X _ V A L U E ;  
  
                 t r y   {  
                         r e t u r n   I n t e g e r . p a r s e I n t ( w o r d ) ;  
                 }   c a t c h   ( N u m b e r F o r m a t E x c e p t i o n   e )   {  
                         r e t u r n   I n t e g e r . M A X _ V A L U E ;  
                 }  
         }  
  
         p r i v a t e   C l a s s < ? > [ ]   g e t P a r a m e t e r T y p e s ( C o n s t r u c t o r   c o n s t r u c t o r )   {  
                 L i s t < C l a s s < ? > >   c o l l e c t   =   A r r a y s . s t r e a m ( c o n s t r u c t o r . g e t P a r a m e t e r T y p e s ( ) ) . m a p ( c   - >   {  
                         i f   ( c . i s P r i m i t i v e ( ) )   r e t u r n   i n t . c l a s s ;  
                         e l s e   t r y   {  
                                 r e t u r n   c . n e w I n s t a n c e ( ) . g e t C l a s s ( ) ;  
                         }   c a t c h   ( I n s t a n t i a t i o n E x c e p t i o n   |   I l l e g a l A c c e s s E x c e p t i o n   e )   {  
                                 e . p r i n t S t a c k T r a c e ( ) ;  
                                 r e t u r n   n u l l ;  
                         }  
                 } ) . c o l l e c t ( C o l l e c t o r s . t o L i s t ( ) ) ;  
                 r e t u r n   c o l l e c t . t o A r r a y ( n e w   C l a s s < ? > [ c o l l e c t . s i z e ( ) ] ) ;  
         }  
  
         p r i v a t e   S t r i n g   g e t C l a s s N a m e ( S t r i n g   i n s )   {  
                 r e t u r n   t h i s . g e t C l a s s ( ) . g e t P a c k a g e ( ) . g e t N a m e ( )   +  
                                 " . "   +   i n s . s u b s t r i n g ( 0 ,   1 ) . t o U p p e r C a s e ( )   +  
                                 i n s . s u b s t r i n g ( 1 ,   i n s . l e n g t h ( ) )   +  
                                 " I n s t r u c t i o n " ;  
         }  
  
         p r i v a t e   S t r i n g   g e t I n s t r u c t i o n T y p e ( )   {  
                 S t r i n g   t e m p   =   u n S h i f t W o r d ( ) ;  
                 S t r i n g   t y p e   =   u n S h i f t W o r d ( ) ;  
                 l i n e   =   t e m p   +   "   "   +   l i n e ;  
                 r e t u r n   t y p e ;  
         }  
 } 