extends Node2D

var images_path = []
var score = 0


func random_image():
	
	""" Cette fonction permet de récupérer le chemin d'une image dans le projet aléatoirement. (Prototype) """
	
	var rng = RandomNumberGenerator.new()
	
	images_path.append("icon.png")
	images_path.append("image.png")
	
	rng.randomize()
	var my_random_number = rng.randf_range(0, images_path.size())
	
	return images_path[my_random_number]


func load_images():
	
	var image = Image.new()
	var image2 = Image.new()
	var image3 = Image.new()
	var image4 = Image.new()
	var image5 = Image.new()
	
	
	image.load(random_image())
	image2.load(random_image())
	image3.load(random_image())
	image4.load(random_image())
	image5.load(random_image())
	
	var texture = ImageTexture.new()
	texture.create_from_image(image,0)
	$Icon.texture = texture;
	
	var texture2 = ImageTexture.new()
	texture2.create_from_image(image2,0)
	$Sprite.texture = texture2;
	
	
	var texture3 = ImageTexture.new()
	texture3.create_from_image(image3,0)
	$Sprite2.texture = texture3;
	
	var texture4 = ImageTexture.new()
	texture4.create_from_image(image4,0)
	$Sprite3.texture = texture4;
	
	var texture5 = ImageTexture.new()
	texture5.create_from_image(image5,0)
	$Sprite4.texture = texture5;

var pos = null
var pos1 = null
var pos2 = null
var pos3 = null
var pos4 =null

func _ready():
	
	load_images()
	
	pos = $Icon.position
	pos1 = $Sprite.position
	pos2 = $Sprite2.position
	pos3 = $Sprite3.position
	pos4 = $Sprite4.position
	
	
	
var selectedFirstItem= false
var selectedItem2 =false
var selectedItem3 =false
var selectedItem4 =false
var selectedItem5 =false

func _on_Area2D_input_event(viewport, event, shape_idx):
	
	if Input.is_action_just_pressed("click") : 
		selectedFirstItem = true
		
func _on_Area2D_input_event2(viewport, event, shape_idx):
	if Input.is_action_just_pressed("click") : 
		selectedItem2 = true
		
func _on_Area2D_input_event3(viewport, event, shape_idx):
	if Input.is_action_just_pressed("click") : 
		selectedItem3 = true

func _on_Area2D_input_event4(viewport, event, shape_idx):
	if Input.is_action_just_pressed("click") : 
		selectedItem4 = true


func _on_Area2D_input_event5(viewport, event, shape_idx):
	if Input.is_action_just_pressed("click") : 
		selectedItem5 = true
		
func _physics_process(delta):
	if selectedFirstItem:
		$Icon.position = lerp($Icon.position, get_global_mouse_position(),25 * delta)
	
	if selectedItem2:
		$Sprite.position = lerp($Sprite.position, get_global_mouse_position(),25 * delta)
		
	if selectedItem3:
		$Sprite2.position = lerp($Sprite2.position, get_global_mouse_position(),25 * delta)
		
		
	if selectedItem4:
		$Sprite3.position = lerp($Sprite3.position, get_global_mouse_position(),25 * delta)
	
	if selectedItem5:
		$Sprite4.position = lerp($Sprite4.position, get_global_mouse_position(),25 * delta)
		
	
	

func _input(event):
	if event is InputEventMouseButton:
		if event.button_index == BUTTON_LEFT and not event.pressed:
			selectedFirstItem = false
			selectedItem2 = false
			selectedItem3 = false
			selectedItem4 = false
			selectedItem5 = false
			if(selectedFirstItem == false):
				$Icon.position = pos
			if(selectedItem2 == false):
				$Sprite.position = pos1
			if(selectedItem3 == false):
				$Sprite2.position = pos2
			if(selectedItem4 == false):
				$Sprite3.position = pos3
			if(selectedItem5 == false):
				$Sprite4.position = pos4
# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass













